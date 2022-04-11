require recipes-bsp/u-boot/u-boot-common.inc
require recipes-bsp/u-boot/u-boot.inc

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI = "git://github.com/openhwgroup/u-boot.git;protocol=https;branch=cva6 \
           file://tftp-mmc-boot.txt \
           file://0001-Increase-binary-size.patch \
           file://0002-First-compiling-LowRisc-driver.patch \
           file://0003-add-Lowrisc-to-the-CV64A6-defconfig.patch \
           file://0004-Driver-lowrisc-adding-realtek-phy.patch \
           file://0005-lowrisc-eth-Correct-return-of-recv-function.patch \
           file://0006-CV64A6-add-ext4-and-fat-functionalities.patch \
           file://0007-CV64A6-add-fitImage-support.patch \
           file://devtool-fragment.cfg \
           "
SRCREV = "cc5fd9916a630cacb30bed2474bcf5df6c5801ae"
SRC_URI[sha256sum] = "d8947969a5834b333afa2a8de9d079a74eb73675d3a7fe56e6a6edd5efae18f9"

DEPENDS:append = " u-boot-tools-native"

# Overwrite this for your server
TFTP_SERVER_IP ?= "127.0.0.1"

do_configure:prepend() {
    sed -i -e 's,@SERVERIP@,${TFTP_SERVER_IP},g' ${WORKDIR}/tftp-mmc-boot.txt
    mkimage -O linux -T script -C none -n "U-Boot boot script" \
        -d ${WORKDIR}/tftp-mmc-boot.txt ${WORKDIR}/${UBOOT_ENV_BINARY}
}

TOOLCHAIN = "gcc"
