package CompositeBuilds_MyProject_SubProjectB

import CompositeBuilds_MyProject_SubProjectB.buildTypes.*
import jetbrains.buildServer.configs.kotlin.v2018_2.*
import jetbrains.buildServer.configs.kotlin.v2018_2.Project

object Project : Project({
    id("CompositeBuilds_MyProject_SubProjectB")
    parentId("CompositeBuilds_MyProject")
    name = "SubProject B"

    buildType(CompositeBuilds_MyProject_SubProjectB_RunAllTestsInSuitesSubproject)
    buildType(CompositeBuilds_MyProject_SubProjectB_TestsFromTestsSubproject)
})
