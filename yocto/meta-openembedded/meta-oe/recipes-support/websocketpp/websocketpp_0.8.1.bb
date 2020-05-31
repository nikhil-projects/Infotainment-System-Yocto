SUMMARY = "C++/Boost Asio based websocket client/server library."
SECTION = "libs/network"
HOMEPAGE = "https://github.com/zaphoyd/websocketpp"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://${S}/COPYING;md5=4d168d763c111f4ffc62249870e4e0ea"

DEPENDS = " ${@bb.utils.contains('DISTRO_FEATURES', 'ptest', 'openssl boost zlib', '', d)} "

SRC_URI = "git://github.com/zaphoyd/websocketpp.git;protocol=https \
           file://0001-Replace-make_shared-with-new-in-some-cases.patch \
           file://0002-Fix-missed-entries-fix-testing.patch \
           file://0001-cmake-Use-GNUInstallDirs.patch \
           file://842.patch \
           file://771.patch \
           file://855.patch \
           file://857.patch \
           file://0001-Correct-clang-compiler-flags.patch \
          "

EXTRA_OECMAKE = "${@bb.utils.contains('DISTRO_FEATURES', 'ptest', '-DBUILD_EXAMPLES=ON -DBUILD_TESTS=ON', '', d)} "

# this is an header only library, do not depend on the main package
RDEPENDS_${PN}-dev = ""

# to add this package to an SDK, since it isn't a reverse-dependency of anything, just use something like this:
# TOOLCHAIN_TARGET_TASK_append = " websocketpp-dev"

# tag 0.8.1
SRCREV= "c6d7e295bf5a0ab9b5f896720cc1a0e0fdc397a7"

S = "${WORKDIR}/git"

inherit cmake
