def call(String user, String serverDomain, String siteName, String confName = "nginx.conf") {
    String path = "/etc/nginx/sites-available/${siteName}";
    sh "ssh ${user}@${serverDomain} 'touch ${path}'"
    sh "scp ./${confName} ${user}@${serverDomain}:${path}"
    sh "ssh ${user}@${serverDomain} 'ln -sf ${path} /etc/nginx/sites-enabled'"
    sh "ssh ${user}@${serverDomain} 'sudo systemctl reload nginx.service'"
    sh "ssh ${user}@${serverDomain} 'sudo certbot --nginx -d ${siteName} -d www.${siteName} --non-interactive --agree-tos'"
}
