# Zygote for a Multi Modules Android Project

## Prerequisites
- Have an account on Github
- Have an account on CircleCI associated with your Github user.
- Have an account on CodeCov associated with your Github user.

## How to use it?
- Click the `Use this template` button and complete the flow until you create a new repository.
- Rename the featureA folder
- Change the package name on the Android manifest of the gateway, presentation and domain modules.
- Change the package name on the Android manifest of app. Also, do not forget to rename the app package and the
`applicationId` on the `build.gradle` file on the app module
- Push changes in the repository that you've just created (do not forget of update this README).

## Continuous Integration
This repository have a basic configuration to build your project on CircleCI. To start using it
you need to turn on your project in [https://circleci.com/add-projects/gh/<User>](https://circleci.com/add-projects/gh/<User>)
Edit the file `.circleci/config.yml` to customize your builds.

## What will you find on this zygote?
Here you'll find an Android template project with some basic configuration.
The project has one main app and 1 folder in wich you will find a expected architecture (3 layers: domain, gateway, and presentation).

Each folder represents a layer on the Clean Architecture model, and have an only responsibility:
- Domain: In here you have to put your business objects.
- Gateway: To obtain and share data with another application.
- Presentation: Determine how to present your business objects.