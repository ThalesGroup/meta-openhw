# Recipe created by recipetool
# This is the basis of a recipe and may need further editing in order to be fully functional.
# (Feel free to remove these comments when editing.)

# Unable to find any files that looked like license statements. Check the accompanying
# documentation and source headers and set LICENSE and LIC_FILES_CHKSUM accordingly.
#
# NOTE: LICENSE is being set to "CLOSED" to allow you to at least start building - if
# this is not accurate with respect to the licensing of the software being built (it
# will not be in most cases) you must specify the correct value before using this
# recipe for anything other than initial testing/development!
LICENSE = "CLOSED"
LIC_FILES_CHKSUM = ""

SRC_URI = "git://github.com/vicgeralds/vitetris;protocol=https;branch=master \
           file://0001-Correct-install-command.patch \
           "


# Modify these as desired
PV = "1.0+git${SRCPV}"
SRCREV = "d725f51fc626b386feb17da623241bf662f72b41"

W = "${WORKDIR}"
S = "${WORKDIR}/git"
B = "${WORKDIR}/build"
I = "${WORKDIR}/install"

do_configure () {
	# Specify any needed configure commands here
	CC="${CC}" ${S}/configure --prefix=${W}
}

do_compile () {
	# You will almost certainly need to add additional arguments here
	#oe_runmake
    make -C ${S} install
}

do_install () {
	# This is a guess; additional arguments may be required
	# oe_runmake install 'DESTDIR=${D}'
    #oe_runmake install
    mkdir -p ${D}/usr/local/bin
    install -m 0644 ${W}/bin/tetris  ${D}/usr/local/bin/tetris
    echo TOTO ${FILES_${PN}}
}

FILES:${PN} += "/usr"
