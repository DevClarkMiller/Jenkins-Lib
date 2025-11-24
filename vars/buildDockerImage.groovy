def call(String path, String imageName, String imagetag) {
	sh """
	docker build \
		-f ${path} \
		-t ${imageName}:${imageTag} \
		.
	"""
}