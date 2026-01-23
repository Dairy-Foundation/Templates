# Templates

This repository contains a series of template build repositories for both
FTC teamcode and FTC library setups.

These libraries all use
[Dairy's FTC Gradle plugins](https://github.com/Dairy-Foundation/Plugins)
to simplify the setup and maintenance process.

These plugins also come with support for the easy usage of popular FTC
libraries. If you wish to see a library added, please open an issue on or PR to
the Plugins repository.

## Build Issues:
These builds make use of gradle's jvm toolchain feature. This means that you may
find that your build stops and tells you that it cannot find a jdk 8, or a jdk 17.
To fix this, you need to install a jdk of this version (I recommend doing so
via android studio's jdk installer itself). You don't need to select it as your
gradle jdk or anything like that, it just needs to be installed, and gradle
needs to be able to find it.

## Getting started:
DO NOT FORK THIS REPOSITORY UNLESS YOU ARE CONTRIBUTING TO IT.

1. select a branch
2. clone that branch: `git clone --single-branch -b <branch-name> <link-to-repo>`
   (remember to replace `<branch-name>` with the actual branch name, and
   `<link-to-repo>` with an actual link to this repository)
3. add your own remote and push to that, you can remove this repository as a
   remote.

E.g.: I want to clone a template into a directory called `TeamCode`.
1. I want the `teamcode-kotlin` branch.
2. I run `git clone --single-branch -b teamcode-kotlin git@github.com:Dairy-Foundation/Templates.git TeamCode` (I like to use ssh).
3. I run `cd TeamCode` to move into the repo.
4. I run `git remote set-url origin git@github.com:Froze-N-Milk/TeamCode.git` to
   use my personal `TeamCode` repository.
6. I run `git branch -m master` to rename my branch to master.
7. I run `git push origin master` to push to the master branch of my new remote.

## The Plugin:
The plugins used in these templates can be found
[here](https://github.com/Dairy-Foundation/Plugins)

This is a quick demo of the features, but does not show the more complex
scenarios.

This also shows all the non-sdk libraries that are currently available.
```kt
// the ftc block contains the ftc libraries dsl
ftc {
    // calling the kotlin function will add kotlin to your project
    kotlin()

    // the sdk block contains dependencies related to the sdk
    sdk {
        // just like when adding a dependency normally,
        // we use the configuration

        // this adds RobotCore to implementation
        implementation(RobotCore)
        // we can also specify a version
        implementation(FtcCommon("11.0.0"))

        // the sdk block specifically has a shared version
        version = "11.0.0"
        // once you change it,
        // all un-specified versions for sdk dependencies will have this version
        // note that changing it won't affect previous actions

        // the sdk block also has a TeamCode function
        TeamCode()
        // or:
        TeamCode("11.0.0")
        // these functions are recommended for use in team code modules,
        // as they provide all the dependencies for you, rather than manually
        // specifying it
    }

    // the acmerobotics blocks contains roadrunner and dashboard
    acmerobotics {
        // the acmerobotics block also contains a road runner block:
        roadrunner {
            implementation(core)
            implementation(ftc)
            implementation(actions)
        }
        // and dashboard
        implementation(dashboard)
    }

    // the dairy block contains dairy dependencies
    dairy {
        // this adds the sloth library to the runtime,
        // you'll still need to set up the plugin
        implementation(Sloth)
        // slothboard is also available
        // sloth is mutually exclusive with dashboard,
        // and gradle will crash with an error telling you
        // why if you have them both
        implementation(slothboard)

        // you can also get latest Mercurial 2.0 beta
        implementation(MercurialFTC)
    }

    // the next block contains next ftc dependencies
    next {
        // core libraries
        implementation(ftc)
        implementation(bindings)
        implementation(control)

        // extensions
        implementation(pedro)
        implementation(roadrunner)
        implementation(fateweaver)
    }

    // the pedro block contains pedro pathing dependencies
    pedro {
        implementation(core)
        implementation(ftc)
        implementation(telemetry)
    }

    // the ftcontrol block contains panels dependencies
    ftcontrol {
        // base library
        implementation(panels)

        // plugins
        implementation(battery)
        implementation(camerastream)
        implementation(capture)
        implementation(configurables)
        implementation(field)
        implementation(gamepad)
        implementation(graph)
        implementation(lights)
        implementation(limelightproxy)
        implementation(opmodecontrol)
        implementation(pinger)
        implementation(telemetry)
        implementation(themes)
        implementation(utils)

        // or fullpanels preset
        implementation(fullpanels)
    }

	// the solvers block contains solverslib dependencies
	solvers {
		// core solverslib
		implementation(core)

		// pedroPathing commands
		implementation(pedroPathing)
	}

	// the fateWeaver block contains fate weaver dependencies
	fateWeaver {
		implementation(core)
		implementation(ftc)
	}

	// the psiLynx block contains psi lynx dependnecies, currently just psi kit
	psiLynx {
		implementation(core)
		implementation(ftc)
	}
}
```

If you're interested in adding more libraries, or maintain one of these
libraries and want to make a PR to the Plugins repository, please do.

## Updating:
All of these repositories have a plugins block near the top of the
`build.gradle.kts` file:

TeamCode:
```gradle.kts
plugins {
	id("dev.frozenmilk.teamcode") version "11.0.0-1.1.0"
}
```

Library:
```gradle.kts
plugins {
	id("dev.frozenmilk.android-library") version "11.0.0-1.1.0"
}
```

These version numbers are separated into 2 parts:

`SDK_version-plugin_version`

When a new version of the SDK releases, we'll release new versions of these
plugins shortly after that default to it.

Just because of the SDK version doesn't stop you from using an older version of
the SDK, but the SDK version indicates the default SDK and the version that it
was built for. For instance, SDK `10.1.1` had some big gradle build changes, so
the plugin is designed around new gradle build changes.

The plugin version indicates changes in internal plugin behaviour. Changes to
the engineering version of the plugin version will not be breaking.

So `10.1.1-0.0.0` -> `10.1.1-0.0.1` will not break your current code. Typically
this change indicates that more libraries have been added, and/or existing
libraries have have their default versions updated (non-breaking) e.g.: Dairy
Util from `0.0.0` -> `0.0.1`.

However `10.1.1-0.0.1` -> `10.1.1-0.1.0` indicates a breaking change. This means
that a library may have been moved, removed, or modified in some way, and/or existing
libraries have have their default versions updated (breaking) e.g.: Dairy
Util from `0.0.0` -> `0.1.0` or `1.0.0`.

So, keep your plugin up to date, and that will keep your SDK up to date, and
your libraries up to date. We'll make sure to do a good job of informing you
what got updated in a breaking way and what you might need to change when we
release a new version.

Also, even if something has been updated, that doesn't mean you need to use the
update, its just default versions, its easy to select your own version of a
library that you want to use.

# Current Branches:

## `teamcode-java`
Basic TeamCode module.
## `teamcode-kotlin`
Basic TeamCode module with Kotlin support.
## `teamcode-sloth`
Basic TeamCode module with Sloth preinstalled, including the gradle tasks.
## `android-library`
Basic template for creating an FTC android library that will be published to the
Dairy maven repository.
## `jvm-library`
Basic template for creating an FTC non-android jvm library that will be
published to the Dairy maven repository.
