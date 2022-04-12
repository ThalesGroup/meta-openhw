# meta-cva6

This README file contains information on the contents of the meta-cva6 layer.

This layer is compatible with honister.

## Dependencies

This layer depends on:

* URI: https://github.com/openembedded/openembedded-core
  * branch: master
  * revision: HEAD
* URI: https://github.com/openembedded/bitbake
  * branch: master
  * revision: HEAD
* URI: https://github.com/riscv/meta-riscv
  * branch: master  
  * revision: HEAD

## Adding the meta-cva6 layer to your build

### Create workspace
```text
mkdir cva6-yocto && cd cva6-yocto
repo init -u https://github.com/eyssartk/meta-cva6  -b master -m tools/manifests/cva6-yocto.xml
repo sync
repo start work --all
```

### Setup Build Environment
```text
. ./meta-riscv/setup.sh
```

### Add meta-cva layer
```text
bitbake-layers add-layer ../meta-cva6
```

## Available Machines

This layer is available for:

* cva6-genesys2: The Digilent FPGA board with the bitstream generated from the [cva6 corev-apu](https://github.com/openhwgroup/cva6).

## Build and flash your image

To generate a console-only image for the cva6-genesys2:
```text
MACHINE=cva6-genesys2 bitbake core-image-minimal
```
Image files will be located in build/tmp-glibc/deploy/images/cva6-genesys2.

Warning, you need to find the correct device image and fill it in the dd's of= parameter:

```gunzip -c build/tmp-glibc/deploy/images/cva6-genesys2/core-image-minimal-cva6-genesys2.wic.gz | sudo dd of=/dev/sd$ bs=1M iflag=fullblock oflag=direct conv=fsync```

The login is "root", no password is needed.

## Tests done

The core-image-minimal has been tested only for the 64bits version of corev-apu with release [3ddf797](https://github.com/openhwgroup/cva6/tree/3ddf797e95923fd11113c8e443046105dfbf8843).

## Todo

- Correction to the u-boot low-risc. TFTP image loading is failing.
- Accelerate the Linux boot time. Suspicion of slow low-risc driver link availability, which blocks depending systemD services.
- Accelerate Linux login time.
