pipeline {
    agent any

    parameters {
        choice(
                name: 'RUNNER',
                choices: ['TestRunnerAPI', 'TestRunnerUI', 'GeneralRunner'],
                description: 'Choose the test runner to execute'
        )
        booleanParam(name: 'Clean_Logs', defaultValue: false, description: 'Wll clean logs on the environment.')
        booleanParam(name: 'Clean_DB', defaultValue: false, description: 'Will clean DB.')
        booleanParam(name: 'SAVE_RESULTS', defaultValue: false, description: 'Want to save results?')
    }

    stages {
        stage('Setup Maven') {
            steps {
                script {
                    // Check if Maven is set
                    def mvnVersion = bat(script: 'mvn -version', returnStatus: true)
                    if (mvnVersion != 0) {
                        echo "Maven not found. Set up Maven."
                    } else {
                        echo "Maven is set."
                    }
                }
            }
        }

        stage('Checkout') {
            steps {
                git branch: 'performance_atf', url: 'https://github.com/Andrian98/master_atf.git'
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean install'
            }
        }

        stage('Test') {
            steps {
                script {
                    def runner = params.RUNNER
                    bat "mvn test -Dtest=${runner}"
                }
            }
        }

        stage('Generate Reports') {
            steps {
                cucumber buildStatus: 'UNSTABLE', fileIncludePattern: 'target/cucumber-reports/*.json'
            }
        }
    }

    post {
        always {
            script {
                // Ensure Cucumber reports are available and generated
                def cucumberResultsFound = fileExists 'target/*.json'
                if (cucumberResultsFound) {
                    cucumber buildStatus: 'UNSTABLE', fileIncludePattern: 'target/cucumber-reports/*.json'
                } else {
                    echo 'No Cucumber report files found.'
                }

                // Archive artifacts if they exist
                archiveArtifacts artifacts: 'target/*.jar', allowEmptyArchive: true
            }
        }
    }
}