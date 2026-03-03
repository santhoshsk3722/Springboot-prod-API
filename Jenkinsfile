pipeline{
    agent any
    tools{
        maven 'Maven3'
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
                sh 'mvn clean package -DskipTests'
            }
        }
        stage('Verify Build'){
            steps{
                sh 'ls target'
            }
        }
        stage('Build Docker Image'){
            steps{
                sh "docker build -t ${IMAGE_NAME} ."
            }
        }
        stage('List Docker Images'){
            steps{
                sh 'docker images'
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