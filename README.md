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
4. I run `git remote --set-url origin git@github.com:Froze-N-Milk/TeamCode.git` to
   use my personal `TeamCode` repository.
6. I run `git branch -m master` to rename my branch to master.
7. I run `git push origin master` to push to the master branch of my new remote.

## Updating:
All of these repositories have a plugins block near the top of the
`build.gradle.kts` file:

TeamCode:
```gradle.kts
plugins {
	id("dev.frozenmilk.teamcode") version "10.1.1-0.1.3"
}
```

Library:
```gradle.kts
plugins {
	id("dev.frozenmilk.android-library") version "10.1.1-0.1.3"
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

# Libraries
At the moment the `ftc` gradle block only supports the SDK and Kotlin.

More documentation on how to use the plugin and configure builds will be added
both here and on the Plugins repository.
