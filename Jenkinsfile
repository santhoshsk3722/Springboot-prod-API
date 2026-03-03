pipeline{
    agent any
    tools{
        gradle 'Gradle'
    }
    environment{
        IMAGE_NAME = 'spring-boot-api'
    }

    stages{
        stage('Checkout code'){
            steps{
                git branch: 'main', url : 'https://github.com/santhoshsk3722/Springboot-prod-API.git'
            }
        }
        stage('Build Application'){
            steps{
                bat 'gradle clean build -x test'
            }
        }
        stage('Verify Build'){
            steps{
                bat 'ls target'
            }
        }
        stage('Build Docker Image'){
            steps{
                bat "docker build -t ${IMAGE_NAME} ."
            }
        }
        stage('List Docker Images'){
            steps{
                bat 'docker images'
            }
        }
    }
    
    post{
        success{
            echo 'Pipeline executed and build successfully'
        }
        failure{
            echo 'Pipeline failed. please check the logs for more details'
        }
    }
}