properties([parameters([choice(choices: ['New job ', 'Docker-J', 'DockerBuild', 'Active-param','Build'], description: 'Select job to give access to', name: 'jobs')])])
def code

node('master') {
  stage('Checkout') {
    checkout scm
  }

  stage('Load') {
    code = load 'monitor.groovy'
  }

  stage('Execute') {
    code.rest(jobs)
  }
}

