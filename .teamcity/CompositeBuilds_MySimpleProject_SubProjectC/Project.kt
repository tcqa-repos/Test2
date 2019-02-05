package CompositeBuilds_MySimpleProject_SubProjectC

import CompositeBuilds_MySimpleProject_SubProjectC.buildTypes.*
import jetbrains.buildServer.configs.kotlin.v2018_2.*
import jetbrains.buildServer.configs.kotlin.v2018_2.Project

object Project : Project({
    id("CompositeBuilds_MySimpleProject_SubProjectC")
    parentId("CompositeBuilds_MySimpleProject")
    name = "SubProject C"

    buildType(CompositeBuilds_MySimpleProject_SubProjectC_RunBothBuilds)
})
