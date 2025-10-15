def call(String user, String serverDomain, String siteName, String confName = "nginx.conf") {
    String path = "/etc/nginx/sites-available/${siteName}";
    sh "ssh ${user}@${serverDomain} 'touch ${path}'"
    sh "scp ./${confName} ${user}@${serverDomain}:${path}"
    sh "ssh ${user}@${serverDomain} 'ln -s ${path} /etc/nginx/sites-enabled"
}
