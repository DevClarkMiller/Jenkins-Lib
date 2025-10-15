def call(String user, String serverDomain, String projectDomain, String buildDirName = "dist") {
    String path = "/var/www/${projectDomain}/html";
    sh "ssh ${user}@${serverDomain} 'mkdir -p ${path} && touch ${path}'"
    sh "scp -r ${buildDirName}/* ${user}@${serverDomain}:path"
}
