# Zygote for a Multi Modules Android Project

## Prerequisites
- Have an account on Github
- Have an account on TravisCI or CircleCI associated with your Github user.
- Have an account on CodeCov associated with your Github user.

## How to use it?
- Click the `Use this template` button and complete the flow until you create a new repository from this project.
- Rename the featureA folder
- Change the package name on the Android manifest of app, gateway, presentation and domain modules.
Also, do not forget to rename the `applicationId` on the `build.gradle` file on the app module
- Push changes in the repository that you've just created (do not forget of change this README).

### Continuous Integration
In this template, you'll find a basic configuration, for both TravisCI and CircleCI. Choose whoever you like and follow the next steps:

##### TravisCI
- Turn on your project on Travis `https://travis-ci.org/<User>/<project-name>/settings`
- Remove the .circleci folder

##### CircleCI
- Find and turn on your project on Circle `https://circleci.com/add-projects/gh/<User>`
- Remove the .travis.yml file

## What will you find on this zygote?
Here you'll find an Android template project with some basic configuration.
The project has one main app and 1 folder in wich you will find a expected architecture (3 layers: domain, gateway, and presentation).

Each folder represents a layer on the Clean Architecture model, and have an only responsibility:
- Domain: In here you have to put your business objects.
- Gateway: To obtain and share data with another application.
- Presentation: Determine how to present your business objects.

All of the modules have Kotlin support.

Also, this project has a basic configuration with Travis/Circle, so when you turn on your project on the CI, we automatic start to create reports.
We run some static code analysis tools, like kLint.
Do not forget to update this README with your badge from TravisCI or CircleCI.