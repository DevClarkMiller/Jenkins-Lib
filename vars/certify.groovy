def call(String user, String serverDomain, String siteName) {
    sh "ssh ${user}@${serverDomain} 'sudo certbot --nginx -d ${siteName} -d www.${siteName} --non-interactive --agree-tos'"
}