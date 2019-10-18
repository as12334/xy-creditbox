<?php
try
{
	//printf(count($argv));
	array_shift($argv); 
	$len=count($argv);
	if($len==5)
	{
		$privateKey=$argv[0];
		$publicKey=$argv[1];
		$data=$argv[2];
		$accCode=$argv[3];
		$encryptMode=$argv[4];
		//一阶加密
		$layer1_data = encryptCCD($data,$privateKey.$accCode);
		/*
		 * encrypt-mode:加密方式
		 * 1.一阶.资料:原资料,一阶.钥匙:私钥+code+account
		 * 二阶:资料.一阶密文+'^'+code+account,以公钥加密.  应用场景: 注册、登入、存款、取款
		 * 2.一阶.资料:原资料,一阶.钥匙:私钥+code+account
		 * 二阶:资料.一阶密文,以公钥加密.   应用场景: 取余额
		 * 3.一阶.资料:原资料,一阶.钥匙:私钥+通关代码
		 * 二阶资料:一阶密文+'^'+通关代码,以公钥加密, 应用场景: 取注单记录
		 */
		 //二阶密文
		 if($encryptMode!="2")
			$layer1_data=$layer1_data."^".$accCode;
		$layer2_data = encryptCCD($layer1_data,$publicKey);
		//二阶结果
		$result="{\"data\":\"".$layer2_data."\"}";
		printf($result);
	}
}catch(Exception $e)
{
	printf($e->getMessage());
}


class Crypt {
	const DEFAULTMODE = 'cfb'; // default encryption mode to use
	const DEFAULTCIPHER = 'twofish'; // default cipher to use

	/**
	* cipher to encrypt with
	*
	* cipher to encrypt with
	*
	* @var      string
	* @access   private
	*/
	private $cipher;

	/**
	* encryption/decription key
	*
	* encryption/decription key
	*
	* @var      string
	* @access   private
	*/
	private $key;

	/**
	* encryption mode to use
	*
	* encryption mode to use - cfb mode should be used for string while cbc mode used for files.
	*
	* @var      string
	* @access   private
	*/
	private $mode;

	/**
	* filter to apply after decrypting, before base64_decode ie gzip_enflate
	*
	* filter to apply after decrypting, before base64_decode ie gzip_enflate
	*
	* @var      string
	* @access   private
	*/
	private $postDecryptFilter;

	/**
	* filter to apply before encrypting ie gzip_deflate
	*
	* filter to apply before encrypting ie gzip_deflate
	*
	* @var      string
	* @access   private
	*/
	private $preEncryptFilter;


	function __construct() {

		// make sure we can use mcrypt_generic_init
		if (!function_exists('mcrypt_generic_init')) {
			App::log(array(__FILE__ ,__LINE__ ,__CLASS__ ,__FUNCTION__), 'Extension not found');
			return false;
		}

		// enable gzip compression if possible, if gzip is not installed but bzip2 is use bzip2 instead
		/*
		if (function_exists('gzdeflate')) {
		$this->set_pre_encrypt_filter('gzdeflate');
		$this->set_post_decrypt_filter('gzinflate');
		} elseif (function_exists('bzcompress')) {
		$this->set_pre_encrypt_filter('bzcompress');
		$this->set_post_decrypt_filter('bzuncompress');
		}
		*/

	}

 	/**
	* clears the key so it can't be fetched by get_key later.
	*
	* clears the key so it can't be fetched by get_key later
	*
	* @access   public
	*/
	public function clearKey() {
		$this->key = '';
	}

	/**
	* clears the pre encrypt filter.
	*
	* clears the pre encrypt filter
	*
	* @access   public
	*/
	function clearPreEncryptFilter() {
		$this->preEncryptFilter = '';
	}

	/**
	* clears the post decrypt filter.
	*
	* clears the post decrypt filter
	*
	* @access   public
	*/
	function clearPostDecryptFilter() {
		$this->postDecryptFilter = '';
	}


	/**
	* shortcut, clears both pre_encrypt and post_decrypt filters.
	*
	* shortcut, clears both pre_encrypt and post_decrypt filters
	*
	* @access   public
	*/
	function clearFilters()	{
		$this->clearPreEncryptFilter();
		$this->clearPostDecryptFilter();
	}

	/**
	* creates an IV.
	*
	* creates an IV
	*
	* @access   public
	*/
	function createIV() {
		// before we create an IV make sure cipher is set
		if ((!isset($this->cipher)) || (!isset($this->mode))) {
			App::log(array(__FILE__ ,__LINE__ ,__CLASS__ ,__FUNCTION__), 'Cipher and mode must be set first');
			return 0;
		}

		// open encryption module
		$td = $this->openCipher();

		// try to generate the iv
		$iv = @mcrypt_create_iv(mcrypt_enc_get_iv_size ($td), MCRYPT_RAND);

		// if we couldn't generate the iv display an error
		if (!$iv) {
			App::log(array(__FILE__ ,__LINE__ ,__CLASS__ ,__FUNCTION__), 'Failed creating IV');
		}

		// cleanup
		@mcrypt_module_close($td);

		// return iv
		return $iv;
	}

	/**
	* Do decryption.
	*
	* @param string The decrypted string data
	* @param boolean Indicates whether to keep IV or not.
	*
	* @access   public
	* @return   string	The decrypted data
	*/
	function decrypt($encrypted, $keepIV = 0) {
		if (0 == strlen($encrypted)) return '';  //nothing to decrpyt or encrypt....
		if ((!isset($this->cipher)) || (!isset($this->mode)) || (!isset($this->key))) {
			App::log(array(__FILE__ ,__LINE__ ,__CLASS__ ,__FUNCTION__), 'Cipher, mode, and key must be set before decrypting');
			return '';
		}

		// extract encrypted value from base64 encoded value
		$data = base64_decode($encrypted);

		// open encryption module
		$td = $this->openCipher();

		// get what size the IV should be
		$ivsize = mcrypt_enc_get_iv_size($td);

		// get the IV from the encrypted string
		$iv = substr($data, 0, $ivsize);

		// remove the IV from the data so we decrypt cleanly
		if ($keepIV != 1) {
			$data = substr($data, $ivsize);
		}

		// initialize decryption
		@mcrypt_generic_init ($td, $this->key, $iv);

		// decrypt the data
		$decrypted = mdecrypt_generic ($td, $data);

		// apply post-decrypt filter (this is usually a decompression call)
		if (!empty($this->postDecryptFilter)) {
			$filter = $this->getPostDecryptFilter();
			$decrypted = $filter($decrypted);
			unset($filter);
		}

		// cleanup
		mcrypt_generic_deinit($td);
		mcrypt_module_close($td);

		// get rid of original data
		unset($data);

		return $decrypted;

	}

	/**
	* decrypts a file.
	*
	* decrypts a file
	*
	* @param string The encrypted file name
	* @param string The name of the file to place the decrypted contents.
	*
	* @access   public
	* @return   integer   The status where 0 means failure while 1 means success.
	*/
	function decryptFile($sourcefile, $destfile) {
		// make sure required fields are specified
		if ((!isset($this->cipher)) || (!isset($this->mode)) || (!isset($this->key))) {
			App::log(array(__FILE__ ,__LINE__ ,__CLASS__ ,__FUNCTION__), 'Cipher, mode, and key must be set before decrypting');
			return 0;
		}

		// make sure file exists and is readable
		if (!is_readable($sourcefile)) {
			return 0;
		}

		// touch destion file so it will exist when we check for it
		@touch($destfile);

		if (!is_writable($destfile)) {
			return 0;
		}

		// read the file into memory and encrypt it
		$fp = fopen($sourcefile, r);

		// return false if unable to open file
		if (!$fp) {
			return 0;
		}

		$filecontents = fread($fp, filesize($sourcefile));
		fclose($fp);

		// open the destionation file for writing
		$dest_fp = fopen($destfile, w);

		// return false if unable to open file
		if (!$dest_fp) {
			return 0;
		}

		// write decrypted data to file
		fwrite($dest_fp, $this->decrypt($filecontents));

		// close encrypted file pointer
		fclose($dest_fp);

		return 1;
	}

	/**
	* Encrypt data which is normally a string.
	*
	* Encrypt data which is normally a string
	*
	* @param string The contents to be encrypted
	*
	* @access   public
	* @return   mixed The encrypted data
	*/
	function encrypt($data) {
		if ((!isset($this->cipher)) || (!isset($this->mode)) || (!isset($this->key))) {
			App::log(array(__FILE__ ,__LINE__ ,__CLASS__ ,__FUNCTION__), 'Cipher, mode, and key must be set before encrypting');
			return '';

		}

		// create an IV
		$iv = $this->createIV();

		// open encryption module
		$td = $this->openCipher();

		// apply pre-encrypt filter (this is usually a compression call)
		if (!empty($this->preEncryptFilter)) {
			$filter = $this->getPreEncryptFilter();
			$data = $filter($data);
			unset($filter);
		}

		// initialize encryption
		mcrypt_generic_init ($td, $this->key, $iv);

		$encrypted_data = mcrypt_generic($td, $data);

		// cleanup
		mcrypt_generic_deinit($td);
		mcrypt_module_close($td);

		// get rid of original data
		unset($data);

		// return base64 encoded string
		return base64_encode($iv . $encrypted_data);
	}

	/**
	* encrypts a file.
	*
	* encrypts a file
	*
	* @param string  The original data that is to be encrypted
	* @param string  File name of the encrypted data.
	*
	* @access   public
	* @return   integer   0 if the function fails.  Otherwise returns 1.
	*/
	function encryptFile($sourcefile, $destfile) {
		// make sure required fields are specified
		if ((!isset($this->cipher)) || (!isset($this->mode)) || (!isset($this->key))) {
			App::log(array(__FILE__ ,__LINE__ ,__CLASS__ ,__FUNCTION__), 'Cipher, mode, and key must be set before encrypting');
			return 0;
		}

		// make sure file exists and is readable
		if (!is_readable($sourcefile)) {
			return 0;
		}

		// touch destion file so it will exist when we check for it
		@touch($destfile);

		if (!is_writable($destfile)) {
			return 0;
		}

		// read the file into memory and encrypt it
		$fp = fopen($sourcefile, r);

		// return false if unable to open file
		if (!$fp) {
			return 0;
		}

		$filecontents = fread($fp, filesize($sourcefile));
		fclose($fp);

		// open the destionation file for writing
		$dest_fp = fopen($destfile, w);

		// return false if unable to open file
		if (!$dest_fp) {
		return 0;
		}

		// write encrypted data to file
		fwrite($dest_fp, $this->encrypt($filecontents));

		// close encrypted file pointer
		fclose($dest_fp);

		return 1;

	}

	/**
	* This function *ATTEMPTS* to generate a secure encryption/decryption key
	*
	* *ATTEMPTS* to generate a secure encryption/decryption key
	*
	* @access   public
	* @return   string   The generated keys data
	*/
	function generateKey() {
		/* generate an random decryption key */
		$decryptkey = bin2hex(md5(uniqid(rand(),1)));

		/* get a unique id with a random prefix */
		$value = md5(uniqid(rand(),1));

		// backup current encryption key
		$oldkey = $this->key;

		// set the encryption/decryption key to the randomly generated decryption key
		$this->setKey($decryptkey);

		// decrypt $value with an invalid decryption key so we get garbage
		$returnkey = $this->decrypt($value, 1);

		// restore encryption key
		$this->key = $oldkey;

		// cleanup variables
		unset($oldkey, $decryptkey);

		// return encryption key, should be base64 encoded for storage
		return $returnkey;

	}

	/**
	* return the name of the current cipher.
	*
	* return the name of the current cipher
	*
	* @access   public
	* @return   string Returns the cipher type used.
	*/
	function getCipher() {
		return $this->cipher;
	}

	/**
	* return the encryption/decryption key.
	*
	* return the encryption/decryption key
	*
	* @access   public
	* @return   string Returns the key used in encryption / decryption
	*/
	function getKey() {
		return $this->key;
	}

	/**
	* return the encryption mode.
	*
	* return the encryption mode
	*
	* @access   public
	* @return   string   Returns the mode used in cipher.
	*/
	function getMode() {
		return $this->mode;
	}

	/**
	* return current post decrypt filter.
	*
	* return current post decrypt filter
	*
	* @access   public
	* @return   string
	*/
	function getPostDecryptFilter()	{
		return $this->postDecryptFilter;
	}

	/**
	* return current pre encrypt filter.
	*
	* return current pre encrypt filter
	*
	* @access   public
	* @return   string
	*/
	function getPreEncryptFilter() {
		return $this->preEncryptFilter;
	}

	/**
	* attempt to set the cipher to $ciphername, verifies ciphername against list of supported ciphers.
	*
	* attempt to set the cipher to $ciphername, verifies ciphername against list of supported ciphers
	*
	* @param string The name of the cipher.
	*
	* @access   public
	* @return   integer 0 of false.  Otherwise returns 1.
	*/
	function setCipher($ciphername)	{
		if (in_array($ciphername, mcrypt_list_algorithms())) {
			$this->cipher = $ciphername;
			return 1;
		} else {
			return 0;
		}
	}

  	/**
	* set encryption key.
	*
	* set encryption key
	*
	* @param string The encryption key to encrypt
	*
	* @access   public
	* @return   integer  Success = 1 and failure = 0
	*/
	function setKey($encryptkey) {
		// make sure cipher and mode are set before setting IV
		if ((!isset($this->cipher)) || (!isset($this->mode))) {
			App::log(array(__FILE__ ,__LINE__ ,__CLASS__ ,__FUNCTION__), 'Cipher and mode must be set before using setting key');
			return 0;
		}

		if (!empty($encryptkey)) {
			// get the size of the encryption key
			$keysize = mcrypt_get_key_size ($this->cipher, $this->mode);
			//echo "Keysize = $keysize, Key = $encryptkey, Key Length = ".strlen($encryptkey)."<br>\n";

			// if the encryption key is less than 32 characters long and the expected keysize is at least 32 md5 the key
			if ((strlen($encryptkey) < 32) && ($keysize >= 32)) {
				$encryptkey = md5($encryptkey);
			// if encryption key is longer than $keysize and the keysize is 32 then md5 the encryption key
			} elseif ((strlen($encryptkey) > $keysize) && ($keysize == 32)) {
				$encryptkey = md5($encryptkey);
			} else {
				if ($keysize > strlen($encryptkey)) {
					// if encryption key is shorter than the keysize, strpad it with space
					$encryptkey = str_pad($encryptkey, $keysize);
				} else {
					// if encryption key is longer than the keysize substr it to the correct keysize length
					$encryptkey = substr($encryptkey, 0, $keysize);
				}
			}
			//echo "Keysize = $keysize, Key = $encryptkey, Key Length = ".strlen($encryptkey)."<br>\n";
			$this->key = $encryptkey;
		} else {
			return 0;
		}
	}

  	/**
	* attempt to set encryption mode to $encryptmode, verifies mode against list of supported modes.
	*
	* attempt to set encryption mode to $encryptmode, verifies mode against list of supported modes
	*
	* @param string The encryption mode to use. cfb mode should be used for string while cbc mode used for files
	*
	* @access   public
	* @return   mixed   No return
	* @version  (optional) insert_version
	* @since	(optional) note variable available since which version
	* @see	(optional) note down related method/variables here.
	*  		E.g.  get_user_name() , $similar_variable.  PHPDoc will
	*		link these together in the HTML document
	*/
	function setMode($encryptmode) {
		// make sure encryption mode is a valid mode
		if (in_array($encryptmode, mcrypt_list_modes())) {
			$this->mode = $encryptmode;
			return 1;
		} else {
			return 0;
		}
	}

	/**
	* Set the post decrypt fileter.  It can be ignored for simple usage..
	*
	* Set the post decrypt fileter.  It can be ignored for simple usage.
	*
	* @access   public
	* @return   integer  Returns 0 if failed, otherwise return 1.
	*/
	function setPostDecryptFilter($function) {
		// if the function exists set the filter and return true
		if (function_exists($function)) {
			$this->postDecryptFilter = $function;
			return 1;
		// function does not exist, return false
		} else {
			return 0;
		}
	}

	/**
	* Set the pre decrypt fileter.  It can be ignored for simple usage..
	*
	* Set the pre decrypt fileter.  It can be ignored for simple usage.
	*
	*
	* @access   public
	* @return   integer  Returns 0 if failed, otherwise return 1.
	*/
	function setPreEncryptFilter($function)	{
		// if function exists set filter and return true
		if (function_exists($function)) {
			$this->preEncryptFilter = $function;
			return 1;
		// function does not exist, return false
		} else {
			return 0;
		}
	}


	/**
	* Attempt to open cipher, verify cipher was opened otherwise throw an error
	*
	* @access private
	* @return resource Encryption descriptor, or FALSE on error
	*/
	private function openCipher() {
		// open encryption module
		$td = @mcrypt_module_open($this->cipher, '', $this->mode, '');

		// display error if we couldn't open the cipher
		if (!$td) {
			App::log(array(__FILE__ ,__LINE__ ,__CLASS__ ,__FUNCTION__), 'Unable to open cipher ' . $this->cipher . ' in ' . $this->mode . ' mode');
		}
		return $td;
	}
}

function encryptCCD($str,$key) {
	$crypt = new Crypt;
	$crypt->setCipher('blowfish');
	$crypt->setMode('cfb');
	$crypt->setKey($key);
	return $crypt->encrypt($str);
}

/**
* Decrypt a string using the SYSTEM_URLCRYPTKEY
*
* @param string $str The string to decrypt
*
* @access public
* @return string The decrypted string
*/
function decryptCCD($str,$key) {
	$crypt = new Crypt;
	$crypt->setCipher('blowfish');
	$crypt->setMode('cfb');
	$crypt->setKey($key);
	return $crypt->decrypt($str);
}
?>

