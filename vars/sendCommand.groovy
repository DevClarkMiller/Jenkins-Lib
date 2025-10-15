def call(String user, String serverDomain, String command) {
    sh "ssh ${user}@${serverDomain} ${command}"
}