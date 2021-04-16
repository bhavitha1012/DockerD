properties([parameters([[$class: 'ChoiceParameter', choiceType: 'PT_SINGLE_SELECT', description: '', filterLength: 1, filterable: false, name: 'Branch', randomName: 'choice-parameter-67197861867200', script: [$class: 'GroovyScript', fallbackScript: [classpath: [], sandbox: false, script: ''], script: [classpath: [], sandbox: false, script: '''def gettags = ("git ls-remote -t -h https://github.com/bhavitha1012/DockerD.git").execute()
return gettags.text.readLines().collect { 
  it.split()[1].replaceAll(\'refs/heads/\', \'\').replaceAll(\'refs/tags/\', \'\').replaceAll("\\\\^\\\\{\\\\}", \'\')
}
''']]]])])

pipeline
{
  environment
  {
    imagename = "798167/declare-image-branch1"
    registryCredential = 'dockerHub'
    dockerImage = ''
  }
    agent any
    stages{
    stage('Clone repository') {
        /* Cloning the Repository to our Workspace */
	    
      steps {
        git 'https://github.com/bhavitha1012/DockerD.git' 
    }
    }
    stage('Build image') {
        /* This builds the actual image */
        steps{
        script {
          dockerImage = docker.build imagename
        }
      }
    }


    stage('Push image') {
        /* 
			You would need to first register with DockerHub before you can push images to your account
		*/
        steps{
        script {
          docker.withRegistry( '', registryCredential ) {
            dockerImage.push("$BUILD_NUMBER")
             dockerImage.push('latest')

          }
        }
      }
    }
   }
}
