package CompositeBuilds_MyProject_SubProjectC

import CompositeBuilds_MyProject_SubProjectC.buildTypes.*
import jetbrains.buildServer.configs.kotlin.v2018_2.*
import jetbrains.buildServer.configs.kotlin.v2018_2.Project

object Project : Project({
    id("CompositeBuilds_MyProject_SubProjectC")
    parentId("CompositeBuilds_MyProject")
    name = "SubProject C"

    buildType(CompositeBuilds_MyProject_SubProjectC_TestsFromTestsSubproject)
    buildType(CompositeBuilds_MyProject_SubProjectC_RunAllTestsInSuitesSubproject)
    buildType(CompositeBuilds_MyProject_SubProjectC_CompileKotlin)
})
