def call(String user, String serverDomain, String projectName, String environment) {
    sh "scp docker-compose-${environment}.yml ${user}@${serverDomain}:/home/${user}/${projectName}/${environment}/docker-compose.yml"
}
