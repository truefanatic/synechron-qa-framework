pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
                sh 'mvn -version'
                sh 'mvn clean compile'
            }
        }

        stage('Run Tests') {
            steps {
                sh 'mvn test'
            }
        }
    }

    post {
        always {
            script {
                if (fileExists('target')) {
                    archiveArtifacts artifacts: 'target/**', fingerprint: true
                } else {
                    echo 'No target directory found, skipping archive.'
                }
            }
        }
    }
}