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


## How dose multiple settings.gradle work?

See [settings.gradle](./settings.gradle).

Just apply the sub `settings.gradle` scripts to mock settings instance.

````
def includeProject(String path, Closure closure) {
    ...
    
    apply {
        from ...
        to new SettingsProxy(...)
    }
}

class SettingsProxy {
    ...
    
    public getRootProject() { ... }

    public void include(String... paths) { ... }

    public project(String path) { ... }

    private String generateDescendantPath(path) { ... }
}
````

## How to substitute dependencies?

See [build.gradle](./build.gradle).

````
...

subprojects {
    ...
    
    configurations.all { configuration ->
        resolutionStrategy.dependencySubstitution.all { DependencySubstitution substitution ->
            final ComponentSelector requested = substitution.requested
            if (requested instanceof ModuleComponentSelector) {
                final Project target = substitutionRules.find(requested.group, requested.module)
                if (target) {
                    println "Substitute: $project.name:$configuration.name '$requested' -> $target"

                    project.evaluationDependsOn("$target.path")
                    substitution.useTarget(target)
                }
            }
        }
    }
}
````
