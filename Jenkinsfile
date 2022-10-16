pipeline {
    agent any

    stages {
        stage('Precheck') {
            steps {
                echo "Precheck is getting performed....."
            }
        }    
        stage('Build') {
            steps {
                // Get some code from a GitHub repository
                git 'https://github.com/mail2sail/JekUpv4.git'

                // Run Maven on a Unix agent.
                sh "mvn clean package"

                // To run Maven on a Windows agent, use
                // bat "mvn -Dmaven.test.failure.ignore=true clean package"
            }

            post {
                // If Maven was able to run the tests, even if some of the test
                // failed, record the test results and archive the jar file.
                success {
                    junit '**/target/surefire-reports/TEST-*.xml'
                    archiveArtifacts 'target/*.jar'
                }
            }
        }
    }
}