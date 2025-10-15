def call(String user, String serverDomain, String siteName, String confName = "nginx.conf") {
    sh "scp ./${confName} ${user}@${serverDomain}:/etc/nginx/sites-available"
}