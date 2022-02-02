SRCREV_machine:cva6-genesys2 ?= "659361086d8b2ee2c8318f390029a350a6e7fb61"

FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"
SRC_URI += "file://defconfig \
            file://0001-Incorporate-lowrisc-drivers-for-latest-kernel-releas.patch \
            file://0005-Update-.gitignore.patch \
            file://0006-Add-Xilinx-emaclite.patch \
            file://0007-Update-for-linux-5.10.patch \
            file://0001-cva6-genesys2-add-32-and-64-bits-dts.patch \
            "

COMPATIBLE_MACHINE:append:cva6-genesys2 = "|cva6-genesys2"
LINUX_VERSION:cva6-genesys2 = "5.10.7"
