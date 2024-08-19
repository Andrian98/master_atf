pipeline {
    agent any

    parameters {
        choice(
                name: 'RUNNER',
                choices: ['TestRunnerAPI', 'TestRunnerUI', 'TestGeneralRunner'],
                description: 'Choose the test runner to execute'
        )
        booleanParam(name: 'SAVE_RESULTS', defaultValue: false, description: 'Want to save results?')
    }

    stages {
        stage('Setup Maven') {
            steps {
                script {
                    // Check if Maven is set
                    def mvnVersion = bat(script: 'mvn -version', returnStatus: true)
                    if (mvnVersion != 0) {
                        error "Maven not found. Set up Maven."
                    } else {
                        echo "Maven is set."
                    }
                }
            }
        }

        stage('Checkout') {
            steps {
                git branch: 'performance_atf', url: 'https://github.com/Andrian98/master_atf.git'
                echo "Connected to the branch 'performance_atf'"
            }
        }

        stage('Test execution') {
            steps {
                script {
                    try {
                        def runner = params.RUNNER
                        bat "mvn clean test -Dtest=runners.${runner}"
                    } catch (err) {
                        currentBuild.result = 'FAILURE'
                        echo err
                    }
                }
            }
        }

    }

    post {
        always {
            script {
                // Archive the HTML report
                archiveArtifacts artifacts: 'target/evidence/**/*.html', allowEmptyArchive: true

                // Publish the HTML report
                publishHTML(target: [
                        allowMissing         : true,
                        alwaysLinkToLastBuild: true,
                        keepAll              : true,
                        reportDir            : 'target/evidence/**/*', // Matches the dynamic directory
                        reportFiles          : '*.html', // Matches the specific report file
                        reportName           : 'Test Report'
                ])

                echo 'Test successfully executed.'
            }
        }
    }
}