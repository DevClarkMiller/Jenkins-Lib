def call(String user, String serverDomain, String projectDomain, String buildDirName = "dist") {
    sh "scp -r ${buildDirName}/* ${user}@${serverDomain}:/var/www/${projectDomain}/html"
}