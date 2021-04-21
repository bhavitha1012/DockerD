def code

node('master') {
  stage('Checkout') {
    checkout scm
  }

  stage('Load') {
    code = load 'monitor.groovy'
  }

  stage('Execute') {
    //code.func()
  }
}

