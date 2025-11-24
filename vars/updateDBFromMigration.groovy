def call(String projectName, String context, String dotnetVersion, String efVersion) {
	sh """
	docker run --rm \
	-v "\$WORKSPACE:/workspace" \
	-w /workspace \
	mcr.microsoft.com/dotnet/sdk:${dotnetVersion} \
	bash -c "dotnet tool install --global dotnet-ef --version ${efVersion} && \
			export PATH=\\\$PATH:/root/.dotnet/tools && \
			dotnet ef database update \
			-s ./services/${projectName}/${projectName}.api \
			-p ./services/${projectName}/${projectName}.data \
			-c ${context} -- --environment Development"
	"""
}
