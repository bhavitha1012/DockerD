properties([parameters([[$class: 'ChoiceParameter', choiceType: 'PT_SINGLE_SELECT', description: '', filterLength: 1, filterable: false, name: 'Job', randomName: 'choice-parameter-188238481468200', script: [$class: 'GroovyScript', fallbackScript: [classpath: [], sandbox: false, script: ''], script: [classpath: [], sandbox: false, script: '''import jenkins.model.*
import hudson.model.*
def jobNames=[]
Jenkins.instance.getAllItems(AbstractItem.class).each {jobNames.add(it.fullName) };
return jobNames''']]]])])
def test
node{
  stage('Checkout') {
    checkout scm
  }
  stage('Load') {
    test = load 'monitor.groovy'
  }
  stage('Execute') {
    test.rest(job)
  }
}
