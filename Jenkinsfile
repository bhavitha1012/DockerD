properties([parameters([[$class: 'ChoiceParameter', choiceType: 'PT_MULTI_SELECT', description: '', filterLength: 1, filterable: false, name: 'Jobs', randomName: 'choice-parameter-85117531329500', script: [$class: 'GroovyScript', fallbackScript: [classpath: [], sandbox: false, script: ''], script: [classpath: [], sandbox: false, script: '''import jenkins.model.*
import hudson.model.*
def jobNames=[]
Jenkins.instance.getAllItems(AbstractItem.class).each
{ jobNames.add(it.fullName) };
return jobNames''']]]])])
def code

node('master') {
  stage('Checkout') {
    checkout scm
  }

  stage('Load') {
    code = load 'monitor.groovy'
  }

  stage('Execute') {
    code.rest(Jobs)
  }
}

