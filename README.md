# Gradle Composite Build Demo

This demo shows how to support multiple `settings.gradle` files for multiple projects building (Sort of like the [includeBuild](https://docs.gradle.org/current/userguide/composite_builds.html), which is only supported in Gradle 3.+).

## Structure of demo project

````
.
├── app
│   └── build.gradle
├── lib1
│   ├── lib1
│   │   └── build.gradle
│   ├── lib1-sample
│   │   └── build.gradle
│   ├── build.gradle
│   └── settings.gradle
├── lib2
│   ├── lib2
│   │   └── build.gradle
│   ├── lib2-sample
│   │   └── build.gradle
│   ├── build.gradle
│   └── settings.gradle
├── build.gradle
└── settings.gradle
````

## How dose multiple `settings.gradle` work?

See [./settings.gradle](./settings.gradle).
