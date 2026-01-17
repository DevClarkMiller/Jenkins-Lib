def call(String user, String serverDomain, String projectName, String environment) {
	sh "ssh ${user}@${serverDomain} 'cd ${projectName}/${environment} && docker compose up -d'"	
}