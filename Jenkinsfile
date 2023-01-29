pipeline {
    agent any
    parameters {
  		booleanParam defaultValue: true, name: 'IsSonarCubeAnalysisRequired'
	}
    stages {
        stage('Precheck') {
            steps {
                echo "Precheck is getting performed....."
            }
        }
        stage('SCM Checkout') {
            steps {
            	// Get some code from a GitHub repository
                git branch: 'master', url: 'https://github.com/mail2sail/JekUpv4.git'
            }
        }
        
        if(${IsSonarCubeAnalysisRequired}){
            stage('Code Quality Analysis') {
            	steps {
            	// Get some code from a GitHub repository
                echo "Code Quality Analysis"
            	}
        	}
        }

        
        
        stage('Build') {
            steps {
                sh "mvn compile"
            }
        }
        stage('Test') {
            steps {
                sh "mvn test"
            }
        }
        stage('Package') {
            steps {
                // Run Maven on a Unix agent.
                sh "mvn package"

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