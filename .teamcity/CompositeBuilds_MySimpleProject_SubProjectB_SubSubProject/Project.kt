package CompositeBuilds_MySimpleProject_SubProjectB_SubSubProject

import CompositeBuilds_MySimpleProject_SubProjectB_SubSubProject.buildTypes.*
import jetbrains.buildServer.configs.kotlin.v2018_2.*
import jetbrains.buildServer.configs.kotlin.v2018_2.Project

object Project : Project({
    id("CompositeBuilds_MySimpleProject_SubProjectB_SubSubProject")
    parentId("CompositeBuilds_MySimpleProject_SubProjectB")
    name = "SubSubProject"

    buildType(CompositeBuilds_MySimpleProject_SubProjectB_SubSubProject_Tests2)
})
