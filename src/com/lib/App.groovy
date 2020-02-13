properties([[$class: 'JiraProjectProperty'],
parameters([string(defaultValue: 'v1', 
description: 'Please provide a version number ', 
name: 'APP_VERSION', trim: false)])])

node {
    stage("Pull Repo"){
        git 'https://github.com/csamatov96/DockerFile-Python-.git'

    }
    stage("Build / Tag Image"){
        sh "docker build -t app_name:${APP_NAME} ." //version parameter can be added instead 
        
    }
    stage("Login to ECR"){
        sh '''$(aws ecr get-login --no-include-email --region us-east-1)'''
        
    }
    stage("Push Image"){
        sh "docker push 676918110389.dkr.ecr.us-east-1.amazonaws.com/repo/app_name:${APP_NAME}" //URI
        
    }
    stage("Notify"){

        
    }

}