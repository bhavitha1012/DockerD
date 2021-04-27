import hudson.model.*    
import jenkins.security.*
import jenkins.model.*
import hudson.security.*
import hudson.model.User   
  def rest(arg_jobname){
    //getting the names of the jobs
    def jobNames = []
    Jenkins.instance.getAllItems(AbstractItem.class).each { 
  jobNames.add(it.fullName) 
}
    def jobName_dynamic = []
    jobName_dynamic.add(arg_jobname)
// For each project
for(item in Hudson.instance.items) {
  for(jobName in jobName_dynamic){
    if(item.name.equalsIgnoreCase(jobName))
    {
      echo "providing access of the job:${jobName} to the user:jenkins-user1"
       def userIDs = ['jenkins-user1']
     // Adding the users and getting user name and user id
        for(userID in userIDs){
        User user = User.getOrCreateByIdOrFullName(userID)
        String sID = user.getId() 
        def authorizationMatrixProperty = item.getProperty(AuthorizationMatrixProperty.class)
        authorizationMatrixProperty?.add(hudson.model.Item.CANCEL, sID)
        authorizationMatrixProperty?.add(Item.WORKSPACE, sID);
        authorizationMatrixProperty?.add(Item.BUILD, sID);
        authorizationMatrixProperty?.add(Run.DELETE, sID);
        authorizationMatrixProperty?.add(Run.UPDATE, sID);
        authorizationMatrixProperty?.add(Item.CONFIGURE, sID);
        authorizationMatrixProperty?.add(Item.DELETE, sID);
        authorizationMatrixProperty?.add(Item.READ, sID);
        authorizationMatrixProperty?.add(com.cloudbees.plugins.credentials.CredentialsProvider.VIEW, sID);
        item.addProperty(authorizationMatrixProperty)
        item.save()
        }
    }
  }
 }
    //getting all the user
    /*User.getAll().each { user ->   
      println user}
   */
     
  }
return this
