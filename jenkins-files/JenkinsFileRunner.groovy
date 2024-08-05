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

    tools {
        maven 'Maven' // Ensure Maven is installed and configured in Jenkins
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'performance_atf', url: 'https://github.com/Andrian98/master_atf.git'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean install'
            }
        }

        stage('Test') {
            steps {
                def runner = params.RUNNER
                sh "mvn test -Dtest=${runner}"
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
            junit 'target/surefire-reports/*.xml'
            cucumber buildStatus: 'UNSTABLE', fileIncludePattern: 'target/cucumber-reports/*.json'
            archiveArtifacts artifacts: 'target/*.jar', allowEmptyArchive: true

            emailext(
                    subject: "Build ${currentBuild.fullDisplayName} - ${currentBuild.result}",
                    body: "Check Jenkins for the detailed results of the build.",
                    to: 'andrian.moisei@endava.com', // recipient email address
                    recipientProviders: [[$class: 'DevelopersRecipientProvider'], [$class: 'RequesterRecipientProvider']]
            )
        }
    }
}