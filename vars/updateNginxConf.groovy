def call(String user, String serverDomain, String siteName, String confName = "nginx.conf") {
    sh "scp ./${confName} ${user}@${serverDomain}:/etc/nginx/sites-available/${siteName}"
    sh "ssh ${user}@${serverDomain} 'ln -s /etc/nginx/sites-available/${siteName}' /etc/nginx-sites-enabled"
}