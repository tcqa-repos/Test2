package CompositeBuilds_MySimpleProject_SubProjectB

import CompositeBuilds_MySimpleProject_SubProjectB.buildTypes.*
import jetbrains.buildServer.configs.kotlin.v2018_2.*
import jetbrains.buildServer.configs.kotlin.v2018_2.Project

object Project : Project({
    id("CompositeBuilds_MySimpleProject_SubProjectB")
    parentId("CompositeBuilds_MySimpleProject")
    name = "SubProject B"

    buildType(CompositeBuilds_MySimpleProject_SubProjectB_Tests1)
    buildType(CompositeBuilds_MySimpleProject_SubProjectB_Tests2)
    buildType(CompositeBuilds_MySimpleProject_SubProjectB_Tests21)
})
