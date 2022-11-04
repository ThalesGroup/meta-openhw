# Recipe created by recipetool
# This is the basis of a recipe and may need further editing in order to be fully functional.
# (Feel free to remove these comments when editing.)

# WARNING: the following LICENSE and LIC_FILES_CHKSUM values are best guesses - it is
# your responsibility to verify that the values are complete and correct.
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=751419260aa954499f7abaabaa882bbe"

SRC_URI = "git://github.com/YoctoForBeaglebone/pacman4console;protocol=https;branch=master \
           file://0001-Makfile-correction.patch \
           "

# Modify these as desired
PV = "1.0+git${SRCPV}"
SRCREV = "ddc229c3478b43b572cef4fc09bb1580f00a1e74"

S = "${WORKDIR}/git"
W = "${WORKDIR}"

# NOTE: some of these dependencies may be optional, check the Makefile and/or upstream documentation
DEPENDS = "ncurses"
RDEPENDS:${PN} = "ncurses-libncurses"

# NOTE: this is a Makefile-only piece of software, so we cannot generate much of the
# recipe automatically - you will need to examine the Makefile yourself and ensure
# that the appropriate arguments are passed in.

do_compile () {
	prefix=${W}/usr/local/ make install
}

do_install () {
    mkdir -p ${D}/usr/local/bin
    mkdir -p ${D}/usr/local/share/pacman/Levels
    install -m 0644 ${W}/usr/local/bin/*  ${D}/usr/local/bin/
    install -m 0644 ${W}/usr/local/share/pacman/Levels/*  ${D}/usr/local/share/pacman/Levels
}

FILES:${PN} += "/usr"
