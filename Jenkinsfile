pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/pjpaparao/springboot.git'
            }
        }

        stage('Build') {
            steps {
                bat 'mvnw clean package'
            }
        }

        stage('Test') {
            steps {
                bat 'mvnw test'
            }
        }
    }
}
