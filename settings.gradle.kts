include(":app")

include(":featureA:domain")
include(":featureA:gateway")
include(":featureA:presentation")

project(path = ":featureA:domain").projectDir = File(rootDir, "featureA/domain")
project(path = ":featureA:gateway").projectDir = File(rootDir, "featureA/gateway")
project(path = ":featureA:presentation").projectDir = File(rootDir, "featureA/presentation")