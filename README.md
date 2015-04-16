# appengine-samples
A (set) of sample applications that run in Google App Engine with comments describing the magic

How to run the basic App Engine Logging Application.
=======================================================

'''bash 

 cd $PROJECT_DIR
 ./gradlew appengineExplodeApp
 gcloud preview app run ./Samples/ManagedVMsLogging/build/exploded-app --enable-mvm-logs

'''
  

