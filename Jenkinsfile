def code

node('java-agent') {
  stage('Checkout') {
    checkout scm
  }

  stage('Load') {
    code = load 'monitor.groovy'
  }

  stage('Execute') {
    code.example1()
  }
}
