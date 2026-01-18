def call(String user, String serverDomain, String siteName, String confName = "nginx.conf", Boolean doRedirect = true) {
    String path = "/etc/nginx/sites-available/${siteName}"
    String redirectFlag = doRedirect ? "" : "--no-redirect"

    sh """
        ssh ${user}@${serverDomain} 'touch ${path}'
        scp ./${confName} ${user}@${serverDomain}:${path}
        ssh ${user}@${serverDomain} 'ln -sf ${path} /etc/nginx/sites-enabled'
        ssh ${user}@${serverDomain} 'sudo systemctl reload nginx.service'
        ssh ${user}@${serverDomain} 'sudo certbot --nginx -d ${siteName} -d www.${siteName} --non-interactive --agree-tos ${redirectFlag}'
    """
}