SRCREV_machine:cv64a6-genesys2 ?= "659361086d8b2ee2c8318f390029a350a6e7fb61"
SRCREV_machine:cv32a6-genesys2 ?= "659361086d8b2ee2c8318f390029a350a6e7fb61"

FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI += "file://0001-Incorporate-lowrisc-drivers-for-latest-kernel-releas.patch \
            file://0005-Update-.gitignore.patch \
            file://0006-Add-Xilinx-emaclite.patch \
            file://0007-Update-for-linux-5.10.patch \
            file://0001-cva6-genesys2-add-32-and-64-bits-dts.patch \
           "

SRC_URI:append:cv32a6-genesys2 = " file://cv32a6-fragment.cfg \
                                   file://cv32a6/defconfig \
                                 "
SRC_URI:append:cv64a6-genesys2 = " file://cv64a6/defconfig \
                                 "

COMPATIBLE_MACHINE:append:cv64a6-genesys2 = "|cv64a6-genesys2"
COMPATIBLE_MACHINE:append:cv32a6-genesys2 = "|cv32a6-genesys2"
LINUX_VERSION = "5.10.7"
