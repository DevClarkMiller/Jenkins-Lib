def call(String path, String imageName, String imageTag) {
	sh """
	docker build \
		-f ${path} \
		-t ${imageName}:${imageTag} \
		.
	"""
}