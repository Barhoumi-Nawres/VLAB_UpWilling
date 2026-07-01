## Project VLAB_UpWilling:

Custom Embedded Linux image for RaspberryPi Zero 2w, built with the Yocto Project (Scarthgap release).

### Layer Dependencies

This project depends on the following layers:

- openembedded-core
- meta-raspberrypi
- meta-openembedded

### Release:
Scarthgap

### Setup process:

1. Build Host packages:
you must install essential host packages on your build host:(Ubuntu Distribution)

```bash
$ sudo apt install build-essential chrpath cpio debianutils diffstat file gawk gcc git iputils-ping libacl1 liblz4-tool locales python3 python3-git python3-jinja2 python3-pexpect python3-pip python3-subunit socat texinfo unzip wget xz-utils zstd
```


2. Install the kas project:
```bash
$ git clone https://github.com/siemens/kas.git
```
3. Clone All Layers and Prepare the Configuration Files

```bash
$ kas/kas-container checkout kas-rpi/kas-image-rpi02w.yml
```
This command clones all the required layers and generates the Yocto configuration files:

- `build/conf/local.conf`
- `build/conf/bblayers.conf`
  
4. Start the container
  
```bash
$ kas/kas-container shell kas-rpi/kas-image-rpi02w.yml
```

5. Building the Image

```bash
$ bitbake custom-image
```
 **Output** 
 
```bash
$ build/tmp/deploy/images/rpi02w64/custom-image-rpi02w64.rootfs-20260628000048.wic
```

This is the image that will be flashed onto the SD card.

6. Copy the Image to the SD Card
) 
```bash
host$ sudo dd if=<IMAGENAME>-<MACHINE>.wic of=/dev/<your_device> bs=1MB conv=fsync
```

Using the device name(<your_device>)without appended number (e.g sdb) which stands for the whole device.

7. Install Picocom :

```bash
$ sudo apt-get install picocom
```

8. Run picocom with:

```bash
$ picocom -b 115200 -r -l /dev/ttyUSB
```


> **Note:**
> Default login credentials:
>
> - **Username:** 'root'
> - **Password:** *(none)*

