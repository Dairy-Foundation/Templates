plugins {
    id("dev.frozenmilk.teamcode") version "12.0.0-1.2.1"
}

ftc {
    // adds support for kotlin
    kotlin()

    // adds the necessary sdk dependencies
    sdk.TeamCode()
}
